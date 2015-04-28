# test-mongo-memory-leak
Small grails application to help finding a memory leak in GORM for Mongo

You need to have mongodb installed and accessible on localhost (no auth)
You can change the size of the sample in Config.groovy (see end of file)

When loading, Bootstrap will create a sample of random Customers
when done access the URL to start loading those records through GORM

http://localhost:8080/test-mongo-memory-leak/leak


I can be reached at pdemilly at gmail.com


Thanks

Pascal
