# Roadmap to Mastering Data Structures & Algorithms (Google Target)

This roadmap is designed to take you from basic recursion to advanced graph algorithms, tailored for top-tier product-based companies (FAANG).

---

## Phase 1: Recursion Mastery (The Foundation)
**Goal:** Visualize the stack, understand base cases, and trust the recursive leap.

### Concepts
1.  **The Call Stack:** Visualizing how functions pause and resume (like the sticky note analogy).
2.  **Base Case & Recursive Relation:** The "stopping condition" and the "breakdown step".
3.  **Parameter Passing:** Passing variables *down* (arguments) vs. passing values *up* (return values).
4.  **Tail Recursion:** Optimization where the recursive call is the final action.

### LeetCode Practice
*   **Easy:**
    *   [509. Fibonacci Number](https://leetcode.com/problems/fibonacci-number/) (Classic start)
    *   [344. Reverse String](https://leetcode.com/problems/reverse-string/) (In-place recursion)
*   **Medium:**
    *   [50. Pow(x, n)](https://leetcode.com/problems/powx-n/) (Divide & Conquer)
    *   [394. Decode String](https://leetcode.com/problems/decode-string/) (Stack simulation)

---

## Phase 2: Backtracking (Brute Force with Brains)
**Goal:** Systematically explore all possibilities and optimize by "pruning" dead ends.

### Concepts
1.  **State Space Tree:** Visualizing every possible decision as a branch.
2.  **Choose, Explore, Un-choose:** The core template of backtracking.
3.  **Pruning:** Stopping early if a path violates constraints (e.g., N-Queens).

### LeetCode Practice
*   **Medium:**
    *   [46. Permutations](https://leetcode.com/problems/permutations/) (The "Hello World" of backtracking)
    *   [78. Subsets](https://leetcode.com/problems/subsets/) (Power set generation)
    *   [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
    *   [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
*   **Hard:**
    *   [51. N-Queens](https://leetcode.com/problems/n-queens/) (Classic constraint satisfaction)
    *   [37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)

---

## Phase 3: Trees (Hierarchical Data)
**Goal:** Master traversals. 90% of tree problems are just modified DFS or BFS.

### Concepts
1.  **Traversals:** Inorder, Preorder, Postorder (Recursive & Iterative).
2.  **Views:** Left/Right/Top/Bottom views (requires BFS/Map).
3.  **BST Properties:** Left < Root < Right.
4.  **Construction:** Building trees from traversal arrays.

### LeetCode Practice
*   **Easy:**
    *   [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
    *   [226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)
*   **Medium:**
    *   [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) (BFS Standard)
    *   [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) (Must Know!)
    *   [98. Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
*   **Hard:**
    *   [124. Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/) (Tricky recursion return values)
    *   [297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

---

## Phase 4: Graphs (Relationships & Networks)
**Goal:** Model problems as nodes and edges. Detect cycles, find paths.

### Concepts
1.  **Representation:** Adjacency Matrix vs. Adjacency List.
2.  **Traversals:** BFS (Shortest path in unweighted) & DFS (Connectivity).
3.  **Topological Sort:** Dependencies (Course Schedule).
4.  **Shortest Paths:** Dijkstra (Weighted), Bellman-Ford.
5.  **MST:** Prim's / Kruskal's (Union-Find).

### LeetCode Practice
*   **Medium:**
    *   [200. Number of Islands](https://leetcode.com/problems/number-of-islands/) (Grid DFS/BFS)
    *   [207. Course Schedule](https://leetcode.com/problems/course-schedule/) (Cycle Detection / Topo Sort)
    *   [133. Clone Graph](https://leetcode.com/problems/clone-graph/)
    *   [994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) (Multi-source BFS)
*   **Hard:**
    *   [127. Word Ladder](https://leetcode.com/problems/word-ladder/) (Graph modeling)
    *   [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/) (Dijkstra/Bellman-Ford)

---

## Phase 5: The "Google" Edge (Industry Trends)
**Goal:** Go beyond just "solving" the problem. Show engineering maturity.

### 1. Code Quality & Readability
*   **Variable Naming:** Use `currNode`, `maxHeight`, `visitedSet` instead of `a`, `b`, `x`.
*   **Modularity:** Break big functions into small helpers (e.g., `isValid(r, c)`).
*   **Edge Cases:** Always check `null`, empty inputs, single nodes *before* writing core logic.

### 2. System Design (HLD/LLD)
*   Even for SDE-1/2, basic LLD is expected.
*   **Object-Oriented:** Can you design a `ParkingLot` or `FileSystem` class structure?
*   **Scalability:** "How would this run on 1TB of data?" (Hint: External Merge Sort, MapReduce concepts).

### 3. Behavioral (Googleyness)
*   **STAR Method:** Situation, Task, Action, Result.
*   **Ambiguity:** Ask clarifying questions! "Is the graph directed?", "Can weights be negative?".
*   **Collaboration:** Speak your thoughts out loud. Treat the interviewer as a coworker.

### 4. Concurrency (Bonus)
*   Basic understanding of Threads, Locks, and Race Conditions.
*   Python's GIL (Global Interpreter Lock) limitations.

---

## Daily Practice Routine
1.  **Topic Focus:** Spend 3-4 days exclusively on one topic (e.g., DFS).
2.  **Pattern Recognition:** Don't memorize code. Memorize *patterns* (e.g., Sliding Window, Two Pointers, Fast/Slow Pointers).
3.  **Mock Interviews:** Explain your logic to a rubber duck or friend.
