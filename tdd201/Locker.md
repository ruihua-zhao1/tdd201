## Tasking
 # 存包
 
 ```

   * Given lockerA capacity is 12
   * When store bagA
   * Then store successfully
   * And get valid ticketA
   
  --------------
  * Given lockerA has zero available space
  * When store bagA
  * Then store failed
  * And get '<No available space>' error 

``` 
 # 取包

 ```

  * Given lockerA stored a bagA
  * And ticketA of bagA
  * When get bagA with ticketA
  * Then get bagA
  
  --------------
  
  * Given lockerA is empty
  * And ticketA
  * When get bag with ticketA
  * Then get '<Invalid ticket>' error 
  
  --------------
  
  * Given lockerA stored bagA and bagB
  * And ticketA has been used to get bagA
  * When get bag with ticketA again
  * Then get '<Invalid ticket>' error

```