public class Pet { 
    String name;
    String type;
    int age;
    
    public Pet () {
      name = "unknown";
      type = "unknown";
      age = 0;
   }
   
   public Pet(String name, String type, int age) {
         this.name = name;
         this.type = type;
         this.age = age;
      }
  
   public void setName(String name) {
      this.name = name;  
   }
   public void setType(String type) {
      this.type = type;   
   }
   public void setAge(int age) {
      this.age = age;   
   }
   
   public String getName() {
      return name;   
   }
   
   public String getType() {
      return type;   
   }
   
   public int getAge() {
      return age;   
   }
   
}
