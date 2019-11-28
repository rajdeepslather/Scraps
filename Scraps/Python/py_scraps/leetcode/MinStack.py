class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = []

    def push(self, x: int) -> None:
        if not self.min or self.min[-1] >= x:
                self.min.append(x)
        self.stack.append(x)

    def pop(self) -> None:
        pop = self.stack.pop()
        if self.min and self.min[-1] == pop:
            self.min.pop()
        return pop

    def top(self) -> int:
        return self.stack[- 1]

    def getMin(self) -> int:
        return self.min[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()