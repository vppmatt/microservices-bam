#!/bin/bash
# cleanup.sh — Recursively delete node_modules, .jar files, temp files, and logs

set -e  # Exit if any command fails

echo "=== System Cleanup Utility ==="
echo "This will delete the following:"
echo "  - All 'node_modules' directories under $(pwd)"
echo "  - All '.jar' files under $(pwd)"
echo "  - Temporary files from /tmp, /var/tmp, and similar locations"
echo "  - All files in /var/log"
echo ""
read -p "Proceed with deletion? (y/N): " confirm

if [[ ! "$confirm" =~ ^[Yy]$ ]]; then
  echo "Aborted."
  exit 1
fi

echo ""
echo ">>> Removing node_modules directories..."
find . -type d -name "node_modules" -prune -print -exec rm -rf {} +

echo ""
echo ">>> Removing .jar files..."
find . -type f -name "*.jar" -print -delete

echo ""
echo ">>> Cleaning temporary files..."
# Common temporary directories
TMP_DIRS=("/tmp" "/var/tmp" "/dev/shm")

for dir in "${TMP_DIRS[@]}"; do
  if [ -d "$dir" ]; then
    echo "  Cleaning $dir ..."
    find "$dir"
