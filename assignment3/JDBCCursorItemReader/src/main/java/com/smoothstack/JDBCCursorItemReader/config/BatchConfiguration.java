package com.smoothstack.JDBCCursorItemReader.config;

import com.smoothstack.JDBCCursorItemReader.listener.HwJobExecutionListener;
import com.smoothstack.JDBCCursorItemReader.listener.HwStepExecutionListener;
import com.smoothstack.JDBCCursorItemReader.model.Transaction;
import com.smoothstack.JDBCCursorItemReader.writer.ConsoleItemWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@EnableBatchProcessing
@org.springframework.context.annotation.Configuration
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

    @Bean
    public JdbcCursorItemReader jdbcCursorItemReader(){
        JdbcCursorItemReader reader = new JdbcCursorItemReader();
        reader.setDataSource(this.dataSource);
        reader.setSql("SELECT * FROM transactions");
        reader.setRowMapper(new BeanPropertyRowMapper(){
            {
                setMappedClass(Transaction.class);
            }
        });
        return reader;
    }

    @Bean
    public Step jdbcCursorStep(){
        return stepBuilderFactory.get("jdbcCursorStep")
                .listener(hwStepExecutionListener)
                .<Integer,Integer>chunk(5)
                .reader(jdbcCursorItemReader())
                .writer(new ConsoleItemWriter())
                .build();
    }

    @Bean
    public Job jdbcCursorJob(){
        return jobBuilderFactory.get("jdbcCursorJob")
                .incrementer(new RunIdIncrementer())
                .listener(hwJobExecutionListener)
                .start(jdbcCursorStep())
                .build();
    }

}
