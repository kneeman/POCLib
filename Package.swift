// swift-tools-version:5.7
import PackageDescription

let package = Package(
    name: "POCLib",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "POCLib",
            targets: ["POCLib"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "poc_lib",
            path: "poc-lib/build/xcframework/poc_lib.xcframework"
        )
    ]
)