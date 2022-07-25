package com.smoothstack.SimpleClientHW.config;

import com.smoothstack.SimpleClientHW.listener.HwJobExecutionListener;
import com.smoothstack.SimpleClientHW.listener.HwStepExecutionListener;
import com.smoothstack.SimpleClientHW.reader.TransactionServiceAdapter;
import com.smoothstack.SimpleClientHW.service.TransactionService;
import com.smoothstack.SimpleClientHW.writer.ConsoleItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private HwJobExecutionListener hwJobExecutionListener;

    @Autowired
    private HwStepExecutionListener hwStepExecutionListener;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    TransactionServiceAdapter transactionServiceAdapter;

    public Tasklet pointlessTasklet(){
        return(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println("Pointless tasklet for demo purposes ");
                return RepeatStatus.FINISHED;
            }
        });
    }

    @Bean
    public Step pointlessStep(){
        return stepBuilderFactory.get("step")
                .listener(hwStepExecutionListener)
                .tasklet(pointlessTasklet())
                .build();
    }

    @Bean
    public ItemReaderAdapter serviceItemReader(){
        ItemReaderAdapter reader = new ItemReaderAdapter();
        reader.setTargetObject(transactionServiceAdapter);
        reader.setTargetMethod("nextTransaction");
        return reader;
    }

    @Bean
    public Step simpleClientStep(){
        return stepBuilderFactory.get("simpleClientStep").
                <Integer, Integer>chunk(5)
                .reader(serviceItemReader())
                .writer(new ConsoleItemWriter())
                .build();
    }

    @Bean
    public Job simpleClientJob(){
        return jobBuilderFactory.get("simpleClientJob")
                .incrementer(new RunIdIncrementer())
                .listener(hwJobExecutionListener)
                .start(pointlessStep())
                .next(simpleClientStep())
                .build();
    }


}
