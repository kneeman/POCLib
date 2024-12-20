// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "POCLib",
    platforms: [.macOS(.v13)],
    dependencies: [
        .package(url: "https://github.com/kneeman/POCLib.git", branch: "main")
    ],
    targets: [
        .binaryTarget(
            name: "poc_lib",
            path: "poc-lib/build/XCFrameworks/poc_lib.xcframework"
        )
    ]
)