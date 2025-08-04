package com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.service;

import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.Locker;
import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.LockerState;
import com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto.Size;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.*;

public class LockerManagerServiceImpl implements LockerMangerService{
    
    Map<Integer,Locker> lockerMap;
    Map<Size, PriorityQueue<Locker>> avialableLocker;
    Map<Size, PriorityQueue<Locker>> occuipedLocker;
    
    ScheduledExecutorService executorService;
    
    public LockerManagerServiceImpl() {
        lockerMap=new HashMap<>();
        avialableLocker=new ConcurrentHashMap<>();
        occuipedLocker=new ConcurrentHashMap<>();
        executorService= Executors.newSingleThreadScheduledExecutor();
    }
    
    @Override
    public void addLocker(int id,Size size) {
        Locker locker = new Locker(id,size);
        lockerMap.put(locker.getId(),locker);
        avialableLocker.putIfAbsent(size, new PriorityQueue<>());
        avialableLocker.get(size).add(locker);
    }
    
    @Override
    public void updateLocker(Locker locker) {
        locker.setLockerState(LockerState.BROKEN);
        lockerMap.put(locker.getId(),locker);
    }
    
    @Override
    public void releaseLocker(Integer lockerId) {
        
        Locker locker = lockerMap.get(lockerId);
        if (locker == null || locker.getLockerState() != LockerState.OCCUPIED) return;
        
        locker.vaccant();
        
        occuipedLocker.getOrDefault(locker.getSize(), new PriorityQueue<>()).remove(locker);
        
        avialableLocker.putIfAbsent(locker.getSize(), new PriorityQueue<>());
        avialableLocker.get(locker.getSize()).add(locker);
        
        System.out.println("Locker released: " + lockerId);
    }
    
    @Override
    public Integer assignLocker(Size packageSize) {
        for (Size size : Size.values()) {
            if (size.canFit(packageSize)) {
                PriorityQueue<Locker> queue = avialableLocker.get(size);
                if (queue == null || queue.isEmpty()) continue;
                
                synchronized (queue) {
                    Locker locker = queue.poll();
                    if (locker == null) continue;
                    
                    locker.occupy();
                    
                    occuipedLocker.putIfAbsent(size, new PriorityQueue<>());
                    occuipedLocker.get(size).add(locker);
                    
                    executorService.schedule(() -> {
                        releaseLocker(locker.getId());
                        System.out.println("Auto-released Locker: " + locker.getId());
                    }, 10, TimeUnit.MINUTES);
                    
                    return locker.getId();
                }
            }
        }
        return null;
        
    }
    
    
}
