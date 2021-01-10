package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
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
public class ProcessorManager implements Serializable {

    private Map<ProcessorType, List<Processor>> processorTypeMap = new HashMap<>();

    public ProcessorManager(){
        DefaultUseCardPreprocessor defaultUseCardPreprocessor = new DefaultUseCardPreprocessor();
        DefaultUseCardPostProcessor defaultUseCardPostProcessor = new DefaultUseCardPostProcessor();
        DefaultJoinPostProcessor defaultJoinPostProcessor = new DefaultJoinPostProcessor();
        DefaultHurtPostProcess defaultHurtPostProcess = new DefaultHurtPostProcess();
        register(defaultUseCardPreprocessor);
        register(defaultUseCardPostProcessor);
        register(defaultJoinPostProcessor);
        register(defaultHurtPostProcess);
    }

    /**
     * 注册处理器
     * @param processor 卡片实例
     */
    public synchronized void register(Processor processor){
        ProcessorType processorType = processor.getProcessorType();
        if(processorTypeMap.get(processorType) == null){
            List<Processor> processors = new ArrayList<>();
            processors.add(processor);
            processorTypeMap.put(processorType,processors);
        }else {
            processorTypeMap.get(processorType).add(processor);
        }
    }

    /**
     * 寻找某种类型的处理器
     * @param processorType 处理器类型
     * @return 已注册的对应类型下所有的处理器
     */
    public List<Processor> getProcessors(ProcessorType processorType){
        return processorTypeMap.get(processorType);
    }


    /**
     * 移除一个实例对应的所有处理器
     * @param owner 卡片实例
     */
    public void removeProcessor(Card owner){
        List<Processor> remove = new ArrayList<>();
        for (List<Processor> processors : processorTypeMap.values()) {
            for (Processor processor : processors) {
                if(processor.getOwner() == owner){
                    remove.add(processor);
                }
            }
            if(remove.size() != 0){
                processors.removeAll(remove);
                remove.clear();
            }
        }
    }

    /**
     * 移除一个实例对应类型的处理器
     * @param owner 卡片实例
     * @param processorType 处理器类型
     */
    public void removeProcessor(Card owner,ProcessorType processorType){
        List<Processor> processors = processorTypeMap.get(processorType);
        if(!CollectionUtils.isEmpty(processors)){
            List<Processor> remove = new ArrayList<>();
            for (Processor processor : processors) {
                if(processor.getOwner() == owner){
                    remove.add(processor);
                }
            }
            if(remove.size() != 0){
                processors.removeAll(remove);
            }
        }
    }
}
