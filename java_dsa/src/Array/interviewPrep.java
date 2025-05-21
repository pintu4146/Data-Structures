class student{
    final  static  int no=40;
    String name;
    public int  getterNo()
    {
        return this.no;
    }
    public void setterName(String name)
    {

        this.name=name;
    }

    public String getter()
    {
        return this.name;
    }
}


public class interviewPrep {
    static int a;
    final static  int b=0;
    public static  void main(String[] str)
    {
        System.out.print(interviewPrep.a);
        System.out.print(a);
        student s=new student();
        s.setterName("pintu");
        System.out.println(s.getter());

    }
}
