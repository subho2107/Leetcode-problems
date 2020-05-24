class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.value = None
        self.children = {}
        self.end = False

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        root = self
        pos = 0
        while pos < len(word) and word[pos] in root.children:
            root = root.children[word[pos]]
            pos+=1
        if pos == len(word):
            root.end = True
        while pos < len(word):
            temp = Trie()
            temp.value = word[pos]
            if pos == len(word)-1:
                temp.end = True
            root.children[word[pos]] = temp
            pos+=1
            root = temp




    def search(self, word: str, fromPref = False) -> bool:
        """
        Returns if the word is in the trie.
        """
        check = True
        root = self
        for pos in range(0, len(word)):
            if word[pos] in root.children:
                root = root.children[word[pos]]
            else:
                check = False
                break
        if fromPref:
            return check
        if check:
            if root.end:
                return check
            else:
                return False
        return check

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        return self.search(prefix, fromPref=True)

obj = Trie()
obj.insert("apple")
print(obj.search("apple"))
print(obj.search("app"))
print(obj.startsWith("app"))
obj.insert("app")
print(obj.search("app"))