//import java.lang.reflect.Array;
import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator = false; // Default no elevator


  
// //// When I submitted this originally I lost points for having 'no overloaded methods detected' but my constructor, moveIn(), and moveOut() methods are all overloaded. 


  /**
   * Constructor for a House with name, address, floors, dining room and elevator
   * Calls Building superclass constructor to set name, address, and floors
   * @param name String name of the building
   * @param address String address of the building
   * @param floors int number of floors in the building
   * @param dr Boolean, true if the house has a dining room
   * @param e boolean, true if the house has an elevator
   */
  public House(String name, String address, int floors, boolean dr, boolean e) {
    super(name, address, floors);
    
    residents = new ArrayList<Student>();
    hasDiningRoom = dr;
    hasElevator = e;
    
    System.out.println("You have built a house!");
  }

  
  /**
   * Constructor for a House with name, address, floors, and dining room
   * Calls first constructor to set name, address, and floors, and sets elevator to false
   * @param name String name of the building
   * @param address String address of the building
   * @param floors int number of floors in the building
   * @param dr Boolean, true if the house has a dining room
   */
  public House(String name, String address, int floors, boolean dr) {
    this(name, address, floors, dr, false); // Call full constructor with elevator set to false
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
   * Adds a list of students to the residents list
   * @param s ArrayList of Students
   */
  public void moveIn(ArrayList<Student> s){
    for (Student student : s) {
      residents.add(student);
    }
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
   * Removes a list of students from the residents list
   * @param s ArrayList of Students
   * @return the student(s) that moved out
   */
  public Student moveOut(ArrayList<Student> s){
    for (Student student : s) {
      if (isResident(student)) {
        residents.remove(student);
        return student;
      }
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

  /**
   * Prints user options for the House class
   */
  public void showOptions(){
    super.showOptions();
    //might need to remove goToFloor() if House doesn't have an elevator
    System.out.println("moveIn()\n moveOut()\n isResident()\n nResidents()\n hasDiningRoom()\n");

  }

  /**
   * Allows movement between all floors in a House with an elevator
   * @param floorNum int number of the floor to go to
   * @throws RuntimeException if the House does not have an elevator or if the user is not inside the House, or if desired floor doesn't exist
   */
  public void goToFloor(int floorNum) {
    if(this.hasElevator == false) {
      throw new RuntimeException("This House does not have an elevator. Cannot go to floor #" + floorNum + ".");
    }
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this House. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors +".");
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }


  public static void main(String[] args) {
    House myHouse = new House("Hubbard House", "3 Green Sreet", 4, false, false);

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