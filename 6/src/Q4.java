public class Q4{
    interface Confidential{
    }
    static class Document{
        String name;
        Document(String name){
            this.name=name;
        }
    }
    static class PublicDocument extends Document{
        PublicDocument(String name){
            super(name);
        }
    }
    static class PrivateDocument extends Document implements Confidential{
        PrivateDocument(String name){
            super(name);
        }
    }
    public static void main(String[]args){
        Document d1=new PublicDocument("Public.pdf");
        Document d2=new PrivateDocument("Private.pdf");
        if(d1 instanceof Confidential)
            System.out.println(d1.name+" is Confidential");
        else
            System.out.println(d1.name+" is not Confidential");
        if(d2 instanceof Confidential)
            System.out.println(d2.name+" is Confidential");
        else
            System.out.println(d2.name+" is not Confidential");
    }
}