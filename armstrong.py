class Solution(object):
    
    ''' 
    Standard Solution 
    Time Complexity: O(n), where n is the number of digits in N 
    2 iterations for finding number of digits and then calculating sum
    def countDigits(self, N):
        count = 0
        while N > 0:
            count += 1
            N = math.floor(N / 10)
        return count
    
    def isArmstrong(self, N):
        """
        :type N: int
        :rtype: bool
        """
        numDigits = self.countDigits(N)
        armSum = 0
        origN = N
        while N > 0:
            digit = N % 10
            armSum += math.pow(digit, numDigits)
            N = math.floor(N / 10)
        if armSum == origN:
            return True
        else:
            return False
    '''
    
    def isArmstrong(self, N):
        '''
            Concise version of code
        '''
        return sum(int(i) ** len(str(N)) for i in str(N)) == N
