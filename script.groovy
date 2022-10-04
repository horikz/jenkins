def buildApp() {
    echo "Building"
}

def testApp() {
    echo "Testing"
}

def deployApp() {
    echo "Deploying version ${params.VERSION}"
}

return this