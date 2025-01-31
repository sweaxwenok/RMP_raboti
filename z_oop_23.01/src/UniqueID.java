import java.util.UUID;

class UniqueID{
    private static int idCounter = 0;

    public static String generateID(){
        idCounter++;
        return UUID.randomUUID().toString() + "-" + idCounter;
    }
}