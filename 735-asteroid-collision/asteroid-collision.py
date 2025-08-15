class Solution:
    def asteroidCollision(self, asteroids):
        result = []
        
        for asteroid in asteroids:
            if asteroid > 0:
                result.append(asteroid)
            else:
                # Destroy smaller positive asteroids
                while result and result[-1] > 0 and result[-1] < abs(asteroid):
                    result.pop()
                
                # Equal size collision
                if result and result[-1] == abs(asteroid):
                    result.pop()
                    continue
                
                # Add if no collision or safe
                if not result or result[-1] < 0:
                    result.append(asteroid)
        
        return result
