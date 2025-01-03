package com.scaler.lld.machinecoding.parkinglot;

import com.scaler.lld.machinecoding.parkinglot.controllers.*;
import com.scaler.lld.machinecoding.parkinglot.dtos.*;
import com.scaler.lld.machinecoding.parkinglot.models.*;
import com.scaler.lld.machinecoding.parkinglot.repositories.*;
import com.scaler.lld.machinecoding.parkinglot.services.*;
import com.scaler.lld.machinecoding.parkinglot.strategies.spotassignmentstrategies.RandomSpotAssignmentStrategy;
import com.scaler.lld.machinecoding.parkinglot.strategies.spotassignmentstrategies.SpotAssignmentStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Shrihari
 */
public class Main {

    private static ParkingLotController parkingLotController;
    private static ParkingFloorController parkingFloorController;
    private static OperatorController operatorController;
    private static ParkingSpotController parkingSpotController;

    private static ParkingLotRequestDto parkingLotRequestDto;
    private static ParkingLotResponseDto parkingLotResponseDto;
    private static ParkingLotFloorResponseDto floor1, floor2, floor3;
    private static GateResponseDto gate1, gate2, gate3;
    private static OperatorResponseDto operator1, operator2, operator3;
    private static ParkingSpotResponseDto parkingSpot1, parkingSpot2, parkingSpot3, parkingSpot4;
    private static List<Integer> tickets = new ArrayList<>();

    private static GateController gateController;

    public static GenerateTicketRequestDto generateTicketRequestDto(String vehicleNumber, VehicleType vehicleType, int gateId) {
        GenerateTicketRequestDto generateTicketRequestDto = new GenerateTicketRequestDto();
        generateTicketRequestDto.setVehicleNumber(vehicleNumber);
        generateTicketRequestDto.setVehicleType(vehicleType);
        generateTicketRequestDto.setGateID(gateId);
        return generateTicketRequestDto;
    }

    public static void main(String[] args) throws InterruptedException {
        IParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        IParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        IParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        IGateRepository gateRepository = new GateRepository();
        IGateTypeRepository gateTypeRepository = new GateTypeRepository();
        IOperatorRepository operatorRepository = new OperatorRepository();
        ITicketRepository ticketRepository = new TicketRepository();
        IVehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();
        IParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        IParkingFloorService parkingFloorService = new ParkingFloorService(parkingFloorRepository, parkingLotService);
        IParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository, parkingLotService, parkingFloorService);
        IGateTypeService gateTypeService = new GateTypeService(gateTypeRepository);
        IOperatorService operatorService = new OperatorService(operatorRepository);
        IGateService gateService = new GateService(gateRepository, gateTypeService, parkingLotService, operatorService);
        ITicketService ticketService = new TicketService(ticketRepository, spotAssignmentStrategy, parkingLotService, operatorService, parkingSpotService);
        IVehicleService vehicleService = new VehicleService(vehicleRepository);
        TicketController ticketController = new TicketController(ticketService, vehicleService, gateService);
        parkingLotController = new ParkingLotController(parkingLotService);
        initParkingLot();
        parkingFloorController = new ParkingFloorController(parkingFloorService);
        initParkingFloor();
        operatorController = new OperatorController(operatorService);
        initOperator();
        gateController = new GateController(gateService);
        initGate();
        parkingSpotController = new ParkingSpotController(parkingSpotService);
        initParkingSpots();
        GenerateTicketResponseDto generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto("KA51N7624", VehicleType.CAR,
                gate1.getGateId()));
        tickets.add(generateTicketResponseDto.getTicketId());
        System.out.println(generateTicketResponseDto);

        generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto("KA01EP0054", VehicleType.CAR,
                gate1.getGateId()));
        tickets.add(generateTicketResponseDto.getTicketId());
        System.out.println(generateTicketResponseDto);

        generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto("KA01EP0014", VehicleType.BIKE,
                gate2.getGateId()));
        tickets.add(generateTicketResponseDto.getTicketId());

        System.out.println(generateTicketResponseDto);

        generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto("KA01EP0014", VehicleType.BIKE,
                gate2.getGateId()));
        tickets.add(generateTicketResponseDto.getTicketId());

        System.out.println(generateTicketResponseDto);

        Thread.sleep(5000);

        BillRepository billRepository = new BillRepository();
        BillService billService = new BillService(ticketService, billRepository, gateService, parkingSpotService);
        BillController billController = new BillController(billService);
        BillResponseDto billResponseDto = billController.createBill(getBillRequestDto());
        System.out.println(billResponseDto);


        generateTicketResponseDto = ticketController.generateTicket(generateTicketRequestDto("KA01EP1111", VehicleType.CAR,
                gate1.getGateId()));
        System.out.println(generateTicketResponseDto);
    }

    private static BillRequestDto getBillRequestDto() {
        BillRequestDto billRequestDto = new BillRequestDto();
        billRequestDto.setGateId(gate2.getGateId());
        billRequestDto.setTicketId(tickets.get(0));
        return billRequestDto;
    }

    public static void initParkingSpots() {
        ParkingSpotRequestDto parkingSpotRequestDto = new ParkingSpotRequestDto();
        parkingSpotRequestDto.setParkingSpotNumber(1);
        parkingSpotRequestDto.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpotRequestDto.setFloorId(floor1.getId());
        parkingSpotRequestDto.setFloorNumber(floor1.getFloorNumber());
        parkingSpotRequestDto.setParkingLotId(parkingLotResponseDto.getId());
        parkingSpotRequestDto.setSupportedVehicleTypes(new ArrayList<>(List.of(VehicleType.BIKE, VehicleType.CAR)));

        parkingSpot1 = parkingSpotController.addParkingSpot(parkingSpotRequestDto);

        parkingSpotRequestDto.setParkingSpotNumber(2);
        parkingSpotRequestDto.setSupportedVehicleTypes(new ArrayList<>(List.of(VehicleType.CAR)));
        parkingSpot2 = parkingSpotController.addParkingSpot(parkingSpotRequestDto);

        parkingSpotRequestDto.setParkingSpotNumber(3);
        parkingSpotRequestDto.setParkingSpotStatus(ParkingSpotStatus.DAMAGED);
        parkingSpotRequestDto.setSupportedVehicleTypes(new ArrayList<>(List.of(VehicleType.BIKE)));
        parkingSpot3 = parkingSpotController.addParkingSpot(parkingSpotRequestDto);

        parkingSpotRequestDto.setParkingSpotNumber(4);
        parkingSpotRequestDto.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpotRequestDto.setSupportedVehicleTypes(new ArrayList<>(List.of(VehicleType.BIKE)));
        parkingSpot4 = parkingSpotController.addParkingSpot(parkingSpotRequestDto);
    }

    public static void initOperator() {
        OperatorRequestDto operatorRequestDto = new OperatorRequestDto();
        operatorRequestDto.setEmployeeID("123");
        operatorRequestDto.setName("Manja - op");
        operator1 = operatorController.createOperator(operatorRequestDto);
        System.out.println(operator1);
        operatorRequestDto.setEmployeeID("234");
        operatorRequestDto.setName("Hanuma - op");
        operator2 = operatorController.createOperator(operatorRequestDto);
        System.out.println(operator2);
    }

    private static void initGate() {
        GateRequestDto gateRequestDto = new GateRequestDto();
        gateRequestDto.setGateNumber(12);
        gateRequestDto.setGateType(GateType.ENTRY_GATE);
        gateRequestDto.setGateStatus(GateStatus.OPEN);
        gateRequestDto.setParkingLotId(parkingLotResponseDto.getId());
        gateRequestDto.setOperatorId(operator1.getId());
        gate1 = gateController.createGate(gateRequestDto);
        System.out.println(gate1);
//        gateRequestDto.setGateNumber(13);
//        gateRequestDto.setGateType(GateType.ENTRY_GATE);
//        gateRequestDto.setGateStatus(GateStatus.OPEN);
//        gateRequestDto.setParkingLotId(parkingLotResponseDto.getId());
//        gateRequestDto.setOperatorId(operator2.getId());
//        gate2 = gateController.createGate(gateRequestDto);
//        System.out.println(gate2);


        gateRequestDto.setGateNumber(14);
        gateRequestDto.setGateType(GateType.EXIT_GATE);
        gateRequestDto.setGateStatus(GateStatus.OPEN);
        gateRequestDto.setParkingLotId(parkingLotResponseDto.getId());
        gateRequestDto.setOperatorId(operator2.getId());
        gate2 = gateController.createGate(gateRequestDto);
        System.out.println(gate2);

//        gateRequestDto.setGateNumber(15);
//        gateRequestDto.setParkingLotId(parkingLotResponseDto.getId());
//        gate3 = gateController.createGate(gateRequestDto);
    }

    private static void initParkingFloor() {
        ParkingLotFloorRequestDto parkingLotFloorRequestDto = new ParkingLotFloorRequestDto();
        parkingLotFloorRequestDto.setFloorNumber(1);
        parkingLotFloorRequestDto.setParkingLotId(parkingLotResponseDto.getId());
        floor1 = parkingFloorController.createParkingFloor(parkingLotFloorRequestDto);
        parkingLotFloorRequestDto.setFloorNumber(2);
        parkingLotFloorRequestDto.setParkingLotId(parkingLotResponseDto.getId());
        floor2 = parkingFloorController.createParkingFloor(parkingLotFloorRequestDto);
        System.out.println(floor1);
        System.out.println(floor2);

        parkingLotFloorRequestDto.setFloorNumber(3);
        parkingLotFloorRequestDto.setParkingLotId(20);
        floor3 = parkingFloorController.createParkingFloor(parkingLotFloorRequestDto);
        System.out.println(floor3);
    }

    private static void initParkingLot() {
        parkingLotRequestDto = new ParkingLotRequestDto();
        parkingLotRequestDto.setCapacity(10);
        parkingLotRequestDto.setName("Informatica");
        parkingLotResponseDto = parkingLotController.createParkingLot(parkingLotRequestDto);
        System.out.println(parkingLotResponseDto);
    }
}
