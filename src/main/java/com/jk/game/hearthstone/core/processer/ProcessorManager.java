package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.enumeration.ProcessorType;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有处于活动状态的事件处理器被统一注册到这里
 * 提供统一的处理器注册,发现和移除方法
 *
 * @author jk
 */
public class ProcessorManager {

    private Map<ProcessorType, List<Processor>> processorMap = new HashMap<>();

    public ProcessorManager(){
        DefaultUseCardPreprocessor defaultUseCardPreprocessor = new DefaultUseCardPreprocessor();
        register(ProcessorType.PRE_USE_CARD,defaultUseCardPreprocessor);
    }

    /**
     * 注册处理器
     * @param processorType 处理器类型
     * @param processor 卡片实例
     */
    public synchronized void register(ProcessorType processorType,Processor processor){
        if(processorMap.get(processorType) == null){
            List<Processor> processors = new ArrayList<>();
            processors.add(processor);
            processorMap.put(processorType,processors);
        }else {
            processorMap.get(processorType).add(processor);
        }
    }

    /**
     * 寻找某种类型的处理器
     * @param processorType 处理器类型
     * @return 已注册的对应类型下所有的处理器
     */
    public List<Processor> getProcessors(ProcessorType processorType){
        return processorMap.get(processorType);
    }

    /**
     * 移除一个实例对应的所有处理器
     * @param processor 卡片实例
     */
    public void removeProcessor(Processor processor){
        for (List<Processor> processors : processorMap.values()) {
            processors.remove(processor);
        }
    }

    /**
     * 移除一个实例对应类型的处理器
     * @param processor 卡片实例
     * @param processorType 处理器类型
     */
    public void removeProcessor(Processor processor,ProcessorType processorType){
        List<Processor> processors = processorMap.get(processorType);
        if(!CollectionUtils.isEmpty(processors)){
            processors.remove(processor);
        }
    }

}
