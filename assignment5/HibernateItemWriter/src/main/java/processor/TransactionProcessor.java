package processor;

import com.smoothstack.springbatch.hibernateitemwriter.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {
    @Override
    public Transaction process(Transaction transaction) throws Exception {
        return transaction;
    }
}


//public class ProductProcessor implements ItemProcessor<Product, Product> {
//    @Override
//    public Product process(Product item) throws Exception {
//        item.setProductDesc(item.getProductDesc().toUpperCase());
//
//        return item;
//    }
//}
