public class MyData {
    public void info(){
        StudentDetail studentDetail=new StudentDetail();
        studentDetail.setMobileNumber("268921");

        Student student1=new Student();
        student1.setStudentName("Nayem");

        Student student2=new Student();
        student2.setStudentName("Md Shahadat Hossen");

        List<Student> studentList=new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        studentDetail.setStudent(studentList);

        Session session=null;
        Transaction txn=null;

        try{
            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            session=sessionFactory.openSession();
            txn=session.beginTransaction();

            session.save(studentDetail);
            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(!txn.wasCommitted()){
                txn.rollback();
            }
            session.flush();
            session.close();
        }
    }
}
