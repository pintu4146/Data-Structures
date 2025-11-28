from itertools import combinations



def generate_all_combinations(arr: list):
    count = 1
    for i in range(0, len(arr)):
        for comb in combinations(arr,i):
            count +=1
            print(list(comb))
    return count


arr = [1, 2, 3, 4, 5]
print(generate_all_combinations(arr))