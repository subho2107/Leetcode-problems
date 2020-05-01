from typing import List
class FirstUnique:

    def __init__(self, nums: List[int]):
        self.queue = {}
        for num in nums:
            if num not in self.queue:
                self.queue[num] = 1
            else:
                self.queue[num] += 1

    def showFirstUnique(self) -> int:
        for num in self.queue:
            if self.queue[num] == 1:
                return num
        return -1
    def add(self, value: int) -> None:
        if value not in self.queue:
            self.queue[value] = 1
        else:
            self.queue[value] += 1

firstUnique = FirstUnique([2,3,5])
firstUnique.showFirstUnique() # return 2
firstUnique.add(5)            # the queue is now [2,3,5,5
firstUnique.showFirstUnique()#/ return 2
firstUnique.add(2)#;            /the queue is now [2,3,5,5,2]
firstUnique.showFirstUnique()#; / return 3
firstUnique.add(3)#;            / the queue is now [2,3,5,5,2,3]
firstUnique.showFirstUnique()