class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        if not sentence:
            return -1
        sentence = sentence.split(" ")
        res = -1
        for pos in range(len(sentence)):
            word = sentence[pos]
            check = True
            temp = 0
            if len(searchWord) > len(word):
                continue
            for temp in range(len(searchWord)):
                if searchWord[temp] != word[temp]:
                    check = False
                    break
            if check:
                res = pos+1
                break
            else:
                continue
        return res
