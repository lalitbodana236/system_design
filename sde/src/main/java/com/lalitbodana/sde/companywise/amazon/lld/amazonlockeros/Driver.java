package com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros;

import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.Size;
import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.service.LockerManagerServiceImpl;



public class Driver {
    public static void main(String[] args) {
        LockerManagerServiceImpl manager = new LockerManagerServiceImpl();
        
        manager.addLocker(1, Size.SMALL);
        manager.addLocker(2, Size.MEDIUM);
        manager.addLocker(3, Size.LARGE);
        
        Integer  lockerId1 = manager.assignLocker(Size.SMALL);
        System.out.println("Assigned Locker: " + lockerId1);
        Integer  lockerId2 = manager.assignLocker(Size.SMALL);
        System.out.println("Assigned Locker: " + lockerId2);
        
        Integer  lockerId3 = manager.assignLocker(Size.SMALL);
        System.out.println("Assigned Locker: " + lockerId3);
        
        Integer  lockerId4 = manager.assignLocker(Size.SMALL);
        System.out.println("Assigned Locker: " + lockerId4);
        
       // manager.printAvailableLockers();
        
        manager.releaseLocker(lockerId1);
       // manager.printAvailableLockers();
    }
}
