class Solution(object):
    def anagramMappings(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        
        '''
            Brute force approach  
            Time Complexity: O(n^2) where n is the number of elements in list A and B 

        result = list()
        for i in A:
            result.append(B.index(i))
        return result
        '''
        
        
        '''
            Improved Solution
            Time Complexity: O(n) where n is the number of elements in list A and B
        '''
        dict_b = dict()
        for j in range(len(B)):
            dict_b[B[j]] = j
            
        
        result = list()
        for i in A:
            result.append(dict_b[i])
            
        return result
