# How to Run the Monolith App

The `ModuleNotFoundError: No module named 'app'` error occurs when running the script directly from inside the `app` directory or without the correct module path.

## Solution

Run the application from the `monolith` directory (the parent of `app`).

### Option 1: Use the run script (Recommended)
Double-click `run.bat` or run it from the terminal:
```powershell
.\run.bat
```

### Option 2: Manual Command
Run the following command from the `monolith` directory:
```powershell
uvicorn app.main:app --reload
```
OR
```powershell
python -m uvicorn app.main:app --reload
```
