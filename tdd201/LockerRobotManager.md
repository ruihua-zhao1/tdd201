 ## Tasking
 # 存包
```
   * Given LockerManager only manage LockerA and LockerB, both lockers has available spaces
   * When LockerManager store bagA
   * Then store successfully
   * And get valid ticketA <ticketNumber>
   * And bagA is stored in LockerA

   * Given LockerManager only manages only LockerA and LockerB, lockerA is full and lockerB has available space
   * When LockerManager store bagA
   * Then store successfully
   * And get valid ticketB <ticketNumber>
   * And bagA is stored in LockerB

   * Given LockerManager only manages LockerA and LockerB, both lockers have no available space
   * When LockerManager store bagA
   * Then store failed
   * And get <No available space> error

   * Given LockerManager only manages RobotA and RobotB
   * And both Robots have available spaces
   * When LockerManager stores bagA
   * Then bag is stored successfully by RobotA
   * And get ticketA <ticketNumber>

   * Given LockerManager only manages RobotA without available space and RobotB with available spaces
   * When LockerManager stores bagA
   * Then bag is stored successfully by RobotB
   * And get valid ticketA <ticketNumber>

   * Given LockerManager only manages RobotA and RobotB and both are full
   * When LockerManager store bagA
   * Then store failed
   * And get <No available space> error

   * Given LockerManager only manages available RobotA and available lockers
   * When LockerManager store bagA
   * Then bag is stored successfully by RobotA
   * And get valid ticketA <ticketNumber>
    
   * Given LockerManager manages full RobotA and available lockerA
   * When LockerManager store bagA
   * Then bag is stored by RobotA success
   * And get valid ticketA <ticketNumber>

   * Given LockerManager manages full RobotA and full lockerA
   * When LockerManager store bagA
   * Then store failed
   * And get <No available space> error

```

 # 取包

```
   * Given LockerManager manages RobotA and RobotB and manager stored bagA success to RobotB with ticketB
   * When get bag with ticketB
   * Then get bagA successfully

   * Given LockerManager manages two Robots and it stored a bag with ticketA
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error 

   * Given LockerManager only manages two lockers and it stored a bag to lockerB with ticketB
   * When get bag with ticketB
   * Then get bag successfully

   * Given LockerManager only manages two lockers and it stored a bag with ticketA
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error 

   * Given LockerManager manages RobotA and lockerA and it stored a bag to RobotA with ticketA
   * When get bag with ticketA
   * Then get bag successfully
   
   * Given LockerManager manages RobotA and lockerA and it stored a bag to lockerA with ticketA
   * When get bag with ticketA
   * Then get bag successfully

   * Given LockerManager manages RobotA and lockerA it stored a bag with ticketA
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error 

```