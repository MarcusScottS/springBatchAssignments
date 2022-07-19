LOAD DATA LOCAL INFILE
'/Users/marcussauceda/Documents/workFolders/smoothstack/lessons/springBatchLessons/2daySpringBatch/transactions.csv'
INTO TABLE hb_student_tracker.transactions
FIELDS TERMINATED BY ',' ENCLOSED BY '' ESCAPED BY ' '
LINES TERMINATED BY '\n' STARTING BY '';
