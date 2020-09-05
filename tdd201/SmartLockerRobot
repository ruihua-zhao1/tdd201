 ## Tasking
 # 存包
```
   * Given SmartLockerRobot manages LockerA and lockerA has one available space
   * When SmartLockerRobot stores bagA
   * Then store successfully
   * And get ticketA <ticketNumber>

   * Given SmartLockerRobot manages LockerA and lockerA has no available space
   * When SmartLockerRobot stores bagA
   * Then store failed
   * And get <No available space> error

   * Given SmartLockerRobot manage LockerA and LockerB, LockerA has 2 available spaces and LockerB has 1 available spaces
   * When SmartLockerRobot store bagA
   * Then store successfully
   * And get valid ticketB <ticketNumber>
   * And bagA is stored in LockerA

   * Given SmartLockerRobot manage LockerA and LockerB, LockerA has 1 available spaces and LockerB has 2 available spaces
   * When SmartLockerRobot stores bagA
   * Then store successfully
   * And get valid ticketA <ticketNumber>
   * And bagA is stored in LockerB

   * Given SmartLockerRobot manage LockerA and LockerB, both lockers has 2 available spaces
   * When SmartLockerRobot store bagA
   * Then store successfully
   * And get valid ticketA <ticketNumber>
   * And bagA is stored in LockerA

   * Given SmartLockerRobot manage LockerA and LockerB, both lockers has no available space
   * When SmartLockerRobot store bagA
   * Then store failed
   * And get <No available space> error
```

 # 取包

```
   * Given SmartLockerRobot manages LockerA and it stored bagA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given SmartLockerRobot manages LockerA and it stored bagA 
   * When get bag with fake ticketA
   * Then get '<Invalid ticket>' error 

   * Given SmartLockerRobot manages LockerA and LockerB
   * And it stored bagA to the lockers and get ticketA
   * When get bag with ticketA
   * Then get bagA successfully

   * Given SmartLockerRobot manages LockerA and LockerB
   * And it stored bagA to the lockers and get ticketA
   * When get bag with fake ticket
   * Then get '<Invalid ticket>' error
```