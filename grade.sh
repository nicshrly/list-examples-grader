CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

files=$(find student-submission/*.java)
for file in $files
do
    if [[ -f $file ]] && [[ $file == student-submission/ListExamples.java ]]
        then
            echo 'submitted correct file'
    else
        echo 'incorrect file/file missing'
        exit
    fi
done

cp student-submission/ListExamples.java grading-area
cp TestListExamples.java grading-area
cp -r lib grading-area

cd grading-area
javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java > output.txt 2>&1
if [[ $? -ne 0 ]]
    then exit
fi
java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > output.txt 2>&1

# if [[ grep "OK" output.txt ]]

head -n 2 output.txt > result.txt
tail -n 1 result.txt > result1.txt

#if [[   output.txt ]]

#sed -n "2p" output.txt > result.txt


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
 