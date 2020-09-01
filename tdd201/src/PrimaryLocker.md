## Tasking
 # 存包

   * Given PrimaryLockerRobot manages LockerA and lockerA has one available space
   * When PrimaryLockerRobot stores bagA
   * Then store successfully
   * And get valid ticketA '<ticketNumber>'
   
   * Given PrimaryLockerRobot manages LockerA and lockerA has no available space
   * When PrimaryLockerRobot stores bagA
   * Then store failed
   * And get '<No available space>' error 
 
   * Given PrimaryLockerRobot manage LockerA and LockerB, both lockers have available spaces
   * When PrimaryLockerRobot stores bagA
   * Then store successfully
   * And get valid ticketA '<ticketNumber>'
   * And bagA is stored in LockerA
   
   * Given PrimaryLockerRobot manage LockerA and LockerB, only LockerB has available spaces
   * When PrimaryLockerRobot store bagA
   * Then store successfully
   * And get valid ticketB '<ticketNumber>'
   * And bagA is stored in LockerB
   
   * Given PrimaryLockerRobot manage LockerA and LockerB, both lockers have no available space
   * When PrimaryLockerRobot store bagA
   * Then store fail
   * And get '<No available space>' error 
   
 # 取包 
   * Given PrimaryLockerRobot manages LockerA and it stored bagA and ticketA
   * When PrimaryLockerRobot get bag with ticketA
   * Then get bagA successfully

   * Given PrimaryLockerRobot manages LockerA and it stored bagA 
   * And invalid ticketA
   * When PrimaryLockerRobot get bag with ticketA
   * Then get '<Invalid ticket>' error 

   * Given PrimaryLockerRobot manages lockerA lockerB, lockerB stored a bagB with ticketB
   * When PrimaryLockerRobot get bag with ticketB
   * Then get bagB successfully