def factorial(n):
    print(f"-> Pushing: factorial({n}) called. Waiting for factorial({n-1})...")
    
    # Base Case
    if n == 1:
        print(f"   * Base Case Reached! factorial(1) returns 1.")
        return 1
    
    # Recursive Call
    result_from_child = factorial(n - 1)
    
    # Resume (Unwinding)
    my_result = n * result_from_child
    print(f"<- Popping: factorial({n}) resumes. Got {result_from_child} from child. Returning {n} * {result_from_child} = {my_result}")
    return my_result

print("--- Starting Stack Demo ---")
final_answer = factorial(5)
print(f"--- Final Result: {final_answer} ---")
