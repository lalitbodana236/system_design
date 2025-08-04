package com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.service;

import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.Locker;
import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.Size;

public interface LockerMangerService {
    
    public void addLocker(int id, Size size);
    public void updateLocker(Locker locker);
    
    public void releaseLocker(Integer lockerId);
    
    public Integer assignLocker(Size packageSize);
}
