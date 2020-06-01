class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.length = 0
        self.dict = {}
    def get(self, key: int) -> int:
        if key in self.dict:
            value = self.dict[key]
            del self.dict[key]
            self.dict[key] = value
            return value
            # print("get", self.dict)
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.dict:
            del self.dict[key]
            self.dict[key] = value
        else:
            if self.length == self.capacity:
                # print(self.recent)
                del self.dict[int(list(self.dict.keys())[0])]
                self.length -= 1
            self.dict[key] = value
            self.length += 1
        # print("put", self.dict)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)