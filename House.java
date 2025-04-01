import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  /**
   * Constructor for a House
   * @param name String name of the building
   * @param address String address of the building
   * @param floors int number of floors in the building
   * @param dr Boolean, true if the house has a dining room
   */
  public House(String name, String address, int floors, boolean dr) {
    super(name, address, floors);
    
    residents = new ArrayList<Student>();
    hasDiningRoom = dr;
    
    System.out.println("You have built a house!");
  }

  /**
   * Acessor for hasDiningRoom
   * @return boolean hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Partial acessor for residents
   * @return int number of residents in the House
   */
  public int nResidents(){
    return residents.size();
  }

  /**
   * Adds a student to the residents list
   * @param s Student
   */
  public void moveIn(Student s){
    residents.add(s);

  }

  /**
   * Removes a student from the residents list
   * @param s Student
   * @return the student that moved out
   */
  public Student moveOut(Student s){
    if (isResident(s)) {
      residents.remove(s);
      return s;
    }
    return null;
    
  }

  /**
   * Checks if a student lives in the House
   * @param s Student
   * @return boolean, true if the student lives there
   */
  public boolean isResident(Student s){
    if (residents.contains(s)){
      return true;
    }else{
      return false;
    }
  }


  public static void main(String[] args) {
    House myHouse = new House("Maple House", "123 College St", 3, true);

    // Create Student objects
    Student s1 = new Student("Alice", "99xxxxxx1", 20);
    Student s2 = new Student("Bob", "99xxxxxx2", 21);
    Student s3 = new Student("Charlie", "99xxxxxx3",22);

    // Test moveIn() 
    myHouse.moveIn(s1); 
    myHouse.moveIn(s2);
    System.out.println(myHouse.nResidents()); // 2

    // Test isResident()
    System.out.println(myHouse.isResident(s1)); // true
    System.out.println(myHouse.isResident(s3)); // false

    // Test moveOut()
    Student removedStudent = myHouse.moveOut(s1);
    System.out.println(removedStudent != null ? removedStudent.getName() : "None"); // Alice
    System.out.println(myHouse.nResidents()); // 1

    // Test moveOut() on a non-resident
    removedStudent = myHouse.moveOut(s3);
    System.out.println(removedStudent != null ? removedStudent.getName() : "None"); // None

    // Test hasDiningRoom()
    System.out.println(myHouse.hasDiningRoom()); // true
  }
}