def check_place(arr, x, y):
    dx = [-1, 0, 1, 0, -2, 0, 2, 0, -1, 1, 1, -1]
    dy = [ 0, 1, 0, -1, 0, 2, 0, -2, 1, 1, -1, -1]
    
    temp = 1
    for i in range(12):
        nx = x + dx[i]
        ny = y + dy[i]
        
        if 0 <= nx < 5 and 0 <= ny < 5:
            if i < 4:
                if check_person(arr, nx, ny):
                    temp = 0
                    break
            elif i < 8:
                if check_person(arr, nx, ny):
                        if i == 4:
                            if not arr[x-1][y] == 'X':
                                temp = 0
                                break
                        elif i == 5:
                            if not arr[x][y+1] == 'X':
                                temp = 0
                                break                            
                        elif i == 6:
                            if not arr[x+1][y] == 'X':
                                temp = 0
                                break                            
                        else:
                            if not arr[x][y-1] == 'X':
                                temp = 0
                                break                        
            else:
                if check_person(arr, nx, ny):
                    if i == 8:
                        if not arr[x-1][y] == 'X' or not arr[x][y+1] == 'X':
                            temp = 0
                            break
                            
                    elif i == 9:
                        if not arr[x][y+1] == 'X' or not arr[x+1][y] == 'X':
                            temp = 0
                            break
                            
                    elif i == 10:
                        if not arr[x][y-1] == 'X' or not arr[x+1][y] == 'X':
                            temp = 0
                            break                        
                        
                    elif i == 11:
                        if not arr[x-1][y] == 'X' or not arr[x][y-1] == 'X':
                            temp = 0
                            break                        
    
    return temp

                    
def check_person(arr, i, j):
    if arr[i][j] == 'P':
        return True
    return False



def solution(places):
    answer = []
     
    for place in places:
        
        arr = []
        
        for line in place:
            temp = list(line)
            arr.append(temp)
        
        result = 1
        
        for i in range(5):
            for j in range(5):
                if arr[i][j] == 'P':
                    
                    result = check_place(arr, i, j)
                    if result == 0:
                        break
                        
            if result == 0:
                break
            
                    

        
        answer.append(result)
        
    return answer