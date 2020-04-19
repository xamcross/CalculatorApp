#!/bin/bash
test $(curl localhost:8765/calculator) -eq "Calculation finished"