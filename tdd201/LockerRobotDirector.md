
 ## Tasking
 # 生成报告
```
   * Given LockerRobotDirector managed 1 LockerManager and managed 1 locker
   * When LockerRobotDirector request to generate the report
   * Then it can generate the correct report
         M a t
           L a t

   * Given LockerRobotDirector managed 1 LockerManager and managed 2 lockers
   * When LockerRobotDirector request to generate the report
   * Then it can generate the correct report
         M a1+a2 t1+t2
           L a1 t1
           L a2 t2

   * Given LockerRobotDirector managed 1 LockerManager managed 1 robot with 2 Lockers
   * When LockerRobotDirector request to generate the report
   * Then it can generate the correct report
        M a1+a2 t1+t2
          R a1+a2 t1+t2
            L a1 t1
            L a2 t2

   * Given LockerRobotDirector managed 1 LockerManager managed 2 robots
   * When LockerRobotDirector request to generate the report
   * Then it can generate the correct report
       M a1+a2+a3 t1+t2+t3
         R a1+a2 t1+t2
           L a1 t1
           L a2 t2
         R a3 t3
           L a3 t3

   * Given LockerRobotDirector managed 1 LockerManager managed robots and lockers
   * When LockerRobotDirector request to generate the report
   * Then it can generate the correct report
      M a1+a2+a3 t1+t2+t3
        R a1+a2 t1+t2
          L a1 t1
          L a2 t2
        R a3 t3
          L a3 t3
        L a4 t4 
        L a5 t5

    * Given LockerRobotDirector managed 2 LockerManager and both managed robots and lockers
    * When LockerRobotDirector request to generate the report
    * Then it can generate the correct report
     M a1+a2+a3 t1+t2+t3
       R a1+a2 t1+t2
         L a1 t1
         L a2 t2
       R a3 t3
         L a3 t3
       L a4 t4 
       L a5 t5
     M a1+a2+a3 t1+t2+t3
       R a1+a2 t1+t2
         L a1 t1
         L a2 t2
       R a3 t3
         L a3 t3
       L a4 t4 
       L a5 t5

    * Given LockerRobotDirector managed 1 LockerManager managed 1 locker and there are 1 unmanaged robot and 1 unmanaged locker 
    * When LockerRobotDirector request to generate the report
    * Then it can generate the correct report
         M a1 t1
           L a1 t1
```
