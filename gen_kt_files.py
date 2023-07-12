import os
import random

code_snippets = [
    "fun main() {\n    println(\"Hello, World!\")\n}",
    "fun sum(a: Int, b: Int): Int {\n    return a + b\n}",
    "fun multiply(a: Int, b: Int): Int {\n    return a * b\n}",
]

base_dir = "kotlin_files"
os.makedirs(base_dir, exist_ok=True)

for i in range(1, 11):
    dir_name = f"{base_dir}/dir{i}"
    os.makedirs(dir_name, exist_ok=True)
    for j in range(10):
        kotlin_file = f"{dir_name}/file{j+1}.kt"
        with open(kotlin_file, "w") as f:
            f.write(random.choice(code_snippets))