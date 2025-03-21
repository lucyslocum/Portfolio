class LowCD:
    def __init__(self, x, num1, num2):
        self.x = x
        self.num1 = num1
        self.num2 = num2
        
    def lowcom(x, num1, num2):
        if (num1 % x == 0 and num2 % x == 0):
             return x
        return LowCD.lowcom(num1, num2, x + 1)
x = 2
num1 = input("Enter the first number:")
num1 = int(num1)
num2 = input("Enter the second number:")
num2 = int(num2)
lcd = LowCD.lowcom(x, num1, num2)
print("The lowest common denominator is:", lcd)
