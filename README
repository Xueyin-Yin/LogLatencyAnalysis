# Program Inputs and Instructions:
This program needs two parameters -- The start time of the log files and the end time of the log files which we want to retrieve

The format of these parameters is yyyy-MM-dd-HH (e.g. ./logAnalyzer 2019-11-30-00 2019-11-30-05)

Before you run the program, you have to make sure LOG_FILE_PATH_FORMAT in the PathGenerator class to be the correct file path.

The program will print the 90%, 95% and 99% percentile response time for READ API requests based on all the log files within the input time range, and the total time it uses.

# Test Instructions:
All the public methods are covered by unit tests.

You can use TestDataGeneratorUtil to generate your own test log data. You can modify the test log file path and the number of lines as you want.

# Performance Analysis
## Time Complexity
O(n)
## Space Complexity
O(n)

### Note: n is the total number of the responses

# Benchmarks:

READ API
90% of requests return a response within 89994.000000 ms
95% of requests return a response within 95000.000000 ms
99% of requests return a response within 98985.000000 ms
My solution took 41325 milliseconds to process a log file containing 2000000 lines and printed the results, with an i7-8750H core and 1TB HDD.

# Copyright
Xueyin Yin
xueyin.yin@outlook.com



