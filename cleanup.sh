#!/bin/bash
# cleanup.sh — Recursively delete all node_modules folders and .jar files

# Exit immediately if any command fails
set -e

# Confirm deletion
read -p "This will delete all 'node_modules' folders and '*.jar' files under $(pwd). Proceed? (y/N): " confirm
if [[ ! "$confirm" =~ ^[Yy]$ ]]; then
  echo "Aborted."
  exit 1
fi

echo "Searching for node_modules directories..."
find . -type d -name "node_modules" -prune -print -exec rm -rf {} +

echo "Searching for .jar files..."
find . -type f -name "*.jar" -print -delete

echo "Cleanup complete!"
