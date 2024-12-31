package factorypatternassignment;

public class DocumentProcessorFactory {

    public static DocumentProcessor getDocumentProcessor(DocumentType documentType, String documentName) {
        switch (documentType) {
            case TEXT -> {
                return new TextDocumentProcessor(documentName);
            }
        }
        return null;
    }

}