# 문제 번호 INPUT
# echo "백준 문제 번호: "
# read problem_number
problem_number=$1
echo "백준 문제 번호 확인: $problem_number"
problem_name="boj$problem_number"
# 폴더 생성
full_path="$problem_name/src/$problem_name"
echo "폴더 생성 : $full_path"
mkdir -p -v $full_path
# 메인 파일 생성
echo "메인 파일 생성 : $full_path/Main.java"
echo "package $problem_name;" > $full_path/Main.java
echo "// https://www.acmicpc.net/problem/$problem_number" >> $full_path/Main.java
i=1
while read line || [ -n "$line" ] ; do
  echo $line >> $full_path/Main.java
  ((i+=1))
done < sample.txt
# 입력 파일 생성
echo "입력 파일 생성 : $full_path/input.txt"
touch $full_path/input.txt
# vscode 설정
echo "vscode launch.json 설정"
sed -i '' "3a\\
{\"type\": \"java\",\\
\"name\": \"$problem_name\",\\
\"request\": \"launch\",\\
\"mainClass\": \"$problem_name.Main\",\\
\"args\": [\"<\",\"$full_path/input.txt\"]},"\
 .vscode/launch.json
# 완료
echo "생성 완료"