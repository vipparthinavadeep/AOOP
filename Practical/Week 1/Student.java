class Student {
    int studentId;
    String name;
    int age;
    void display() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.studentId = 1;
        s1.name = "Alice";
        s1.age = 20;
        s1.display();

        Student s2 = new Student();
        s2.studentId = 2;
        s2.name = "Bob";
        s2.age = 22;
        s2.display();

        Student s3 = new Student();
        s3.studentId = 3;
        s3.name = "Charlie";
        s3.age = 21;
        s3.display();
    }
}