package com.smoothstack.SkipItem.config;

import com.smoothstack.SkipItem.models.Transaction;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.item.file.*;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.*;
import org.springframework.batch.item.file.transform.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.io.FileSystemResource;
import com.smoothstack.SkipItem.processor.TransactionProcessor;
import org.springframework.core.io.Resource;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private StepBuilderFactory steps;

    @Autowired
    private JobBuilderFactory jobs;

//    @Value("input/transactions.csv")
//    private Resource inputResource;

    private Resource outputResource = new FileSystemResource("output/outFile.csv");

    //    @Bean
//    @StepScope
//    public FlatFileItemReader reader( @Value("#{jobParameters['inFile']}") FileSystemResource inputFile){
//        FlatFileItemReader reader = new FlatFileItemReader();
//        reader.setResource(inputFile);
//        reader.setLinesToSkip(1);
//        reader.setLineMapper(new DefaultLineMapper<Transaction>(){
//            {
//                setFieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>(){
//                    {
//                        setTargetType(Transaction.class);
//                    }
//                });
//
//                setLineTokenizer(new DelimitedLineTokenizer(){
//                    {
//                        setNames(new String[]{"date", "county", "area", "number", "totalArea", "averageArea", "totalTransactionAmount", "minimumTransactionAmount", "maximumTransactionAmount", "unitPriceMinimum", "unitPriceMaximum", "unitPriceMedian", "unitPriceAverage", "unitPriceStandardDeviation", "month", "year", "indx"});
//                        setDelimiter(",");
//                    }
//                });
//            }
//        });
//        return reader;
//    }
    @Bean
    @StepScope
    public FlatFileItemReader<Transaction> reader2(){
        return new FlatFileItemReaderBuilder<Transaction>()
                .name("csvReader")
                .resource(new FileSystemResource("src/main/java/com/smoothstack/SkipItem/input/transactions.csv"))
                .linesToSkip(1)
                .delimited()
                //                .names("productId","prodName","productDesc"  ,"price","unit")
                .names("date", "county", "area", "number", "totalArea", "averageArea", "totalTransactionAmount", "minimumTransactionAmount", "maximumTransactionAmount", "unitPriceMinimum", "unitPriceMaximum", "unitPriceMedian", "unitPriceAverage", "unitPriceStandardDeviation", "month", "year", "indx")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Transaction>(){
                    {
                        setTargetType(Transaction.class);
                    }
                })
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemWriter<Transaction> writer(){
        FlatFileItemWriter<Transaction> writer = new FlatFileItemWriter<>();

        writer.setResource(new FileSystemResource("output/outFile.csv"));
        // append once
        writer.setAppendAllowed(false);

        writer.setLineAggregator(new DelimitedLineAggregator<Transaction>(){
            {
                setDelimiter("*");
                setFieldExtractor(new BeanWrapperFieldExtractor<Transaction>() {
                    {
                        setNames(new String[]{"date", "county", "area", "number", "totalArea", "averageArea", "totalTransactionAmount", "minimumTransactionAmount", "maximumTransactionAmount", "unitPriceMinimum", "unitPriceMaximum", "unitPriceMedian", "unitPriceAverage", "unitPriceStandardDeviation", "month", "year", "indx"});
                    }
                });
            }
        });

        return writer;
    }

    @Bean
    public Step transactionStep(){
        return steps.get("jdbcItemWriterStep")
                .<Transaction, Transaction>chunk(200)
                .reader(reader2())
                .faultTolerant()
                .skipPolicy(new ItemSkipPolicy())
                .skip(FlatFileParseException.class)
                .skipLimit(500)
                .processor(new TransactionProcessor())
                .writer(writer())
                .build();
    }

    @Bean
    public Job transactionOutFileJob(){
        return jobs.get("transactionOutFileJob")
                .start(transactionStep())
                .build();
    }

}