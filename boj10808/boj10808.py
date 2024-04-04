import sys

sys.stdin = open('input.txt')

word = input()
for i in range(97, 97+26):
    # print(chr(i))
    print(word.count(chr(i)), end=' ')

