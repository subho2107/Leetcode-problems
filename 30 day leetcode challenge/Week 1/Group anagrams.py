from typing import List


def groupAnagrams( strs: List[str]) :
        dictOfAnagrams = {}
        for word in strs:
            reformed = str(''.join(sorted(word)))
            if reformed in dictOfAnagrams:
                dictOfAnagrams[reformed].append(word)
            else:
                dictOfAnagrams[reformed] = [word]
        return list(dictOfAnagrams.values())

print(groupAnagrams(list(map(str, input().rstrip().split()))))