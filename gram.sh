echo "=== Compiling==="

make

echo "=== Testing on invalid input: reject.ul ==="
java Test reject.ul
echo "=== Testing on valid but messy input: messy.ul ==="
> output.txt
java Test messy.ul >> output.txt

echo " "
echo "Pretty Print output in output.txt"

echo "=== clean up ==="

make clean
