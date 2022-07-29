package com.smoothstack.springbatch.hibernateitemwriter;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.ItemProcessor;

public class ItemSkipPolicy implements SkipPolicy {
    @Override
    public boolean shouldSkip(Throwable T, int skipCount) throws SkipLimitExceededException {
        if(T instanceof Throwable){
            skipCount++;
            return true;
        }
        return false;
    }
}